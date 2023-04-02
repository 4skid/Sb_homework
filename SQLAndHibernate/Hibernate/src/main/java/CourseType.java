import lombok.Getter;

@Getter
public enum CourseType {

    DESIGN(0,"DESIGN"),
    PROGRAMMING(1,"PROGRAMMING"),
    MARKETING(2, "MARKETING"),
    MANAGEMENT(3, "MANAGEMENT"),
    BUSINESS(4,"BUSINESS");

    private final Integer id;
    private final String title;

    CourseType(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
}
