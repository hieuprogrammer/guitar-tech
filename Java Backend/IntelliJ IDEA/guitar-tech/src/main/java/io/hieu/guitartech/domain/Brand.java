package io.hieu.guitartech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = { "name", "guitars" })
@ToString(exclude = "guitars")
@Entity
public class Brand extends BaseEntity {
    private String name;

    @OneToMany(
            mappedBy = "brand",
            orphanRemoval = false,
            fetch = FetchType.LAZY)
    private List<Guitar> guitars = new ArrayList<Guitar>();

    public Brand(Long id) {
        super(id);
    }
}