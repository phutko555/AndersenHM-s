package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class AdminE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    private List<WorkSpacesE> workSpaces = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkSpacesE> getWorkSpaces() {
        return workSpaces;
    }

    public void setWorkSpaces(List<WorkSpacesE> workSpaces) {
        this.workSpaces = workSpaces;
    }
}
