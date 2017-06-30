public class List<T> {

    protected T[] items;
    protected int numItems;

    public List(){
        items = (T[]) new Object[3];
        numItems = 0;
    }

    public boolean isEmpty(){
        return numItems == 0;
    }

    public int size(){
        return numItems;
    }

    public void removeAll(){
        items = (T[]) new Object[3];
        numItems = 0;
    }

    public void add(int index, T item) throws  ListException{
        if(numItems ==  items.length){
            //resizing
            T[] newItems = (T[]) new Object[(int)(items.length*1.5)];
            for(int i = 0; i<items.length; i++){
                newItems[i] = items[i];
            }
            items = newItems;
        }

        if (index >= 0 && index <= numItems){
            for (int i = numItems-1; i >= index; i--){
                items[i+1] = items[i];
            }

            items[index] = item;
            numItems++;
        }
        else
            throw new ListException("List exception on add");
    }

    public T get(int index) throws ListException{
        if (index >= 0 && index < numItems)
            return items[index];
        else
            throw new ListException("List exception on get");
    }

    public void remove(int index) throws ListException{
        if (index >= 0 && index < numItems){
            for (int i = index+1; i < numItems; i++) {
                items[i-1] = items[i];
            }
            items[items.length-1] = null;
            numItems--;
        }
        else
            throw new ListException("List exception on remove");
    }

    public String toString(){
        String returnString = "";
        for(int i = 0; i<numItems; i++){
            returnString += items[i] + " ";
        }
        return returnString;
    }
}
