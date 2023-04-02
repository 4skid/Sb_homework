import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ReferenceParser extends RecursiveAction {
    private final String URL;
    private static final Set<String> links = new HashSet<>();

    public ReferenceParser(String url) {
        URL = url;
    }

    public Set<String> getSortedLinks() {
        return new TreeSet<>(links);
    }

    @Override
    protected void compute() {
        Set<ReferenceParser> setChildLinks = new HashSet<>();
        try {
            Thread.sleep(150);
            Document document = Jsoup.connect(URL).get();
            Elements elements = document.select("a");
            for (Element element : elements) {
                String link = element.absUrl("href");
                if(!link.isEmpty() && link.startsWith(URL) && !links.contains(link) && !link.contains("#")) {
                    links.add(link);
                    ReferenceParser referenceParser = new ReferenceParser(link);
                    referenceParser.fork();
                    setChildLinks.add(referenceParser);
                }
            }
        } catch (HttpStatusException e ){
            System.out.printf("Code status: %s -> %s\n", e.getStatusCode(), e.getUrl());
        } catch (UnsupportedMimeTypeException e) {
            System.out.printf("Exception message: %s -> %s\n", e.getMessage(), e.getUrl());
        } catch (InterruptedException | IOException e){
            e.printStackTrace();
        }
        setChildLinks.forEach(ForkJoinTask::join);
    }
}
