
/**
 * Enumerado para representar formas
 * @author andresouto
 * @version 1.0
 */
public enum Cell {

	BUSY("B"),
	FREE("_");
	
	private final String name;       

	/**
	 * dah o nome ah celula
	 * @param s
	 * @reuqires s!= null
	 */
    private Cell(String s) {
        name = s;
    }
    
    @Override
    /**
     * representacao textual das celulas
     */
    public String toString() {
    	return this.name;
    }
	
}
