/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* headNew = NULL;
        Node* temp = head;
        Node* prev = NULL;
        Node* temp2 = NULL;

        while(temp!=NULL){
            if(headNew == NULL){
                headNew = new Node(temp->val);
                prev = headNew;
                temp = temp->next;
                continue;
            }
            temp2 = new Node(temp->val);
            prev->next = temp2;
            prev = temp2;
            temp2 = temp2->next;
            temp = temp->next;
        }
        int value;
        temp = head;
        temp2 = headNew;
        Node* temp3 = temp2;
        while(temp!=NULL){
            if(temp->random !=NULL){
                value = temp->random->val;
                temp3 = headNew;
                while(temp3!=NULL){
                    if(temp3->val == value){
                        temp2->random = temp3;
                        break;
                    }
                    else{
                        temp3 = temp3->next;
                    }
                }
            }
            // else{
            //     temp2->random = NULL;
            // }
            temp = temp->next;
            temp2 = temp2 ->next;
        }

        return headNew;
    }
};