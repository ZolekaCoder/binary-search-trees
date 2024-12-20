

/** Zoleka Fuyana Class Program
*Class that is used to create objects for GenericsKBArray and GenericsKbBSTApp*/
public class GenericsFile implements Comparable<GenericsFile>
{   
   /**Privatized instance variable encapsulation*/
    private String term; /**term is a word from textfile*/
    private String statement; /**statement is a description from textfile*/
    private double conf; /**conf is a confidence interval from textfile*/
    
    /**Constructor used for creating objects, each object represents a line from the text file, where the term, statement and confidence score are made to be instance variables of the object for easier access
    
   *@param term this is a term
   *@param statement this is a statement
   *@param conf this is a confidence interval
   */

    public GenericsFile(String term, String statement, double conf )
    {   
        this.term = term;
        this.statement = statement;
        this.conf = conf;

    }
    /**Encapsulation: Used to receive term from text file
    *@return the term*/
    public String getTerm()
    {
      return this.term;
    }
    /**Encapsulation: Used to receive description of term from text file
    *@return statement*/
    public String getStatement()
    {
      return this.statement;
    }
    /**Encapsulation: Used to receive confidence score from text file
    *@return confidence score*/
    public double getConf()
    {
      return this.conf;
    }
    /**Encapsulation: Used to set term from text file
    *@param term parameter sent to method setTerm*/   
    public void setTerm(String term)
    {
      this.term = term;
    }
    /**Encapsulation: Used to set associated description with term from text file
    *@param statement parameter sent to method setStatement*/ 
    public void setStatement(String statement)
    {
      this.statement = statement;
    }
    /**Encapsulation: Used to set confidence score from text file for object
    *@param conf parameter sent to method setConf*/
    public void setConf(double conf)
    {
      this.conf = conf;
    }
    /**Method used to ensure correct format for result when printing*/
    public String toString()
    {
      return (getTerm() + "   " + getStatement() + "    " + getConf());
    }
    
    /**Method used to compare two objects of class type GenericsFile
    *@param other another object of GenericsFile class type*/
    public int compareTo(GenericsFile other)
    {
      return (other.getTerm().compareTo(this.term));
    }



}
