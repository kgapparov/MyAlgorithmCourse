package lessons_from_class.problem8;

public class BFS extends BreadthFirstSearch{

    private int componentCount = 0;

    public BFS(Graph graph) {
        super(graph);
    }

    @Override
    protected void additionalProcessing() {
        this.componentCount++;
    }

    public int getComponentCount() {
        return componentCount;
    }


}
