class GenericClass<T> 
{ 
   
    T obj; 
    GenericClass(T obj) 
    { 
    	this.obj = obj; 
    }  
    public T getObject() 
    {
    	return this.obj;
    } 

    public static void main (String[] args) 
    { 
      
        GenericClass <Integer> iObj = new GenericClass<Integer>(15); 
        System.out.println(iObj.getObject()); 
   
        GenericClass <String> sObj = new GenericClass<String>("Generic classes"); 
        System.out.println(sObj.getObject()); 
    } 
}