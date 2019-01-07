package se.terhol.pisemka32;

/**
 * Magazine.
 * 
 * @author Radek Oslejsek
 * @version 2010-12-11
 */
public class Magazine {

    private String name;
    private int    issue;

    /**
     * @param name Name of the magazine, must not be null
     * @param issue Issue number > 0
     */
    public Magazine(String name, int issue) {
        if (name == null) throw new NullPointerException("name");
        if (issue < 0) throw new IllegalArgumentException("issue");
        this.name = name;
        this.issue = issue;
    }
    
    /**
     * @return name of this magazine
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return issue number of this magazine
     */
    public int getIssue() {
        return issue;
    }
    
    @Override
    public String toString() {
        return name + " /" + issue + "/";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof Magazine)) {
            return false;
        }
        
        Magazine m = (Magazine) obj;
        return (name.equals(m.name) && issue == m.issue);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + name.hashCode();
        hash = 31 * hash + issue;
        return hash;
    }
    
}
