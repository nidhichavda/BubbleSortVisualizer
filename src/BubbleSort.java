public class BubbleSort {

    private int[] array;
    private int array_index, Compare_index;
   

    public BubbleSort(int[] array)
    {
        this.array = array;
        array_index = 0;
        Compare_index= Integer.MAX_VALUE;
        // Init(array);
    }

    public void Init(int[] array)
    {
        this.array = array;
        array_index = 0;
        Compare_index= 0;
    }

    public int[] sortOnlyOneItem(){

        if(array[Compare_index] > array[Compare_index+1])
        {
            int temp = array[Compare_index];
            array[Compare_index]=array[Compare_index+1];
            array[Compare_index+1]=temp;
        }

        if((Compare_index+1) >= (array.length - array_index- 1))
        {
            array_index++;
            Compare_index=0;
        }
        else Compare_index++;

        return array;
    }


    public int[] getArray(){
        return array;
    }

    public void setArray(int[] array)
    {
        this.array = array;
    }

    public int getArrayIndex(){
        return array_index;
    }

    public void setArrayIndex(int array_index)
    {
        this.array_index = array_index;
    }

    public int getCompareIndex(){
        return Compare_index;
    }

    public void setCompareIndex(int Compare_index){
        this.Compare_index = Compare_index;

    }
}
