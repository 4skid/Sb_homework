
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Entity
@Table(name = "LinkedPurchaseList")
@AllArgsConstructor
@Data
public class LinkedPurchaseList implements Serializable {
    @EmbeddedId
    private KeyLinkedPurchaseList id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;


    public LinkedPurchaseList(KeyLinkedPurchaseList id) {
        this.id = id;
    }


}
