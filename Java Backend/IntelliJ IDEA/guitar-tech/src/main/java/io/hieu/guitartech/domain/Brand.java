package io.hieu.guitartech.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Brand name is required!")
    private String name;

    private String logoUrl;

    @OneToMany(
            mappedBy = "brand",
            orphanRemoval = false,
            fetch = FetchType.LAZY)
    private List<Guitar> guitars = new ArrayList<Guitar>();

    public Brand(Long id) {
        super(id);
    }
}