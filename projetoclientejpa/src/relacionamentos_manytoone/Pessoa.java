package relacionamentos_manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Pessoa {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
   
  private String name;
  
  @ManyToOne
  private Departamento departamento;
  
  public Pessoa() {}

  public Pessoa(String name) {
    this.name = name;
  }


  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Pessoa [id=" + id + ", name=" + name + "]";
  }

}