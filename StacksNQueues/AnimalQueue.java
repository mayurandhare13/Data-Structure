import java.util.LinkedList;

abstract class Animal
{
    private int order;
    protected String name;
    
    public Animal(String n) { name = n; }

    public void setOrder(int ord){ order = ord; }
    
    public int getOrder() { return order; }

    public boolean isOlderThan(Animal a)
    {
        return this.order < a.getOrder();
    }
}


class AnimalQueue
{
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // acts as timestamp

    public void enqueue(Animal a)
    {
        //order is used as a sort of timestamp, so that we can compare the insertion order of dog or cat
        a.setOrder(order);
        order++;

        if(a instanceof Dog) dogs.addLast((Dog)a);
        else if(a instanceof Cat) cats.addLast((Cat)a);
    }

    public Animal dequeueAny()
    {
        /* look at top of dog and cat queues, and pop the queue with oldest value */
        if(dogs.size() == 0)
        {
            return dequeueCats();
        }
        else if(cats.size() == 0)
        {
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat))
        {
            return dequeueDogs();
        }
        else
        {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs()
    {
        return dogs.poll();
    }

    public Cat dequeueCats()
    {
        return cats.poll();
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("D");
        Dog d2 = new Dog("O");
        Dog d3 = new Dog("G");

        Cat c1 = new Cat("C");
        Cat c2 = new Cat("A");
        Cat c3 = new Cat("T");

        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(d1);
        aq.enqueue(c2);
        aq.enqueue(c1);
        aq.enqueue(d3);
        aq.enqueue(c3);
        aq.enqueue(d2);
    }
}