package spring.core.mvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.ForeignKey;
import javax.persistence.ConstraintMode;



@Entity
@Table(name = "Subjects")
public class Subject {

	@Id
	@NotNull(message="ID Cannot be Null")
	@Min(value=0,message="ID Cannot be Zero")
	@Column(name = "subjectid")
	private long subjectid;
	
	@NotEmpty(message="Title Cannot be Blank")
	@Column(name = "subjecttitle")
	private String subtitle;
	
	@Min(value=1,message="Time cannot be less than Zero")
	@Column(name = "subjectduration")
	private int duration_in_hours;

	/*@ManyToMany(fetch = FetchType.LAZY, 
			cascade = {
					CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST }, 
			targetEntity = Book.class)
	@JoinTable(name = "subject_book", 
	inverseJoinColumns = @JoinColumn(name = "bookid", nullable = false, updatable = false), 
	joinColumns = @JoinColumn(name = "subjectid", nullable = false, updatable = false),
	foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
    inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Set<Book> reference = new HashSet<Book>();*/

	public Subject() {
	}

	public long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDuration_in_hours() {
		return duration_in_hours;
	}

	public void setDuration_in_hours(int duration_in_hours) {
		this.duration_in_hours = duration_in_hours;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration_in_hours;
		result = prime * result + (int) (subjectid ^ (subjectid >>> 32));
		result = prime * result + ((subtitle == null) ? 0 : subtitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (duration_in_hours != other.duration_in_hours)
			return false;
		if (subjectid != other.subjectid)
			return false;
		if (subtitle == null) {
			if (other.subtitle != null)
				return false;
		} else if (!subtitle.equals(other.subtitle))
			return false;
		return true;
	}

	public Subject(long subjectid, String subtitle, int duration_in_hours) {
		super();
		this.subjectid = subjectid;
		this.subtitle = subtitle;
		this.duration_in_hours = duration_in_hours;
	}

	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", subtitle=" + subtitle + ", duration_in_hours=" + duration_in_hours
				+ "]";
	}

	
	
}