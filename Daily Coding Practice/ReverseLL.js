class ListNode
{
    constructor(value)
    {
        this.value = value;
        this.next = null;
    }
}

function reverse(head)
{
    // Step 1
    let prev = null;
    let current = head;
    let following = head;

    //Step 2
    while(current != null)
    {
        following = following.next;
        current.next = prev;
        prev = current;
        current = following;
    }

    // Step 3
    return prev;
}


let head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);

let reverseHead = reverse(head);
let i = 0;
while(i < 3)
{
    console.log(reverseHead.value);
    reverseHead = reverseHead.next;
    i++;
}