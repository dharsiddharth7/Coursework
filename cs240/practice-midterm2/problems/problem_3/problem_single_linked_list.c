#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "LinkedList.h"

//Initialize the linked list
void llist_init(LinkedList * list)
{
        list->head = NULL;
}

// Prints the linked list
void llist_print(LinkedList * list) {
        
        ListNode * e;

        if (list->head == NULL) {
                printf("{EMPTY}\n");
                return;
        }

        printf("{");

        e = list->head;
        while (e != NULL) {
                printf("%d", e->value);
                e = e->next;
                if (e!=NULL) {
                        printf(", ");
                }
        }
        printf("}\n");
}

// Problem ( 1/4 ) 
/******************************************************************************
 * TODO: Return the number of elements (ListNodes) in the linked list.
 *
 * Parameters: list -- find the number of elements contained in this single
 * linked list
 *
 * Return: the number of elements 
 *
 * Return Type: integer
 *****************************************************************************/
int llist_number_elements(LinkedList * list) {
    // Write Your Code Here
    	ListNode * e = (ListNode *) malloc(sizeof(ListNode));
	e = list -> head;

	if(e == NULL) {
		return 0;	
	}

	int i = 0;

	while(e != NULL) {
		i++;
		e = e -> next;
	}
	return i;
}

// Problem ( 2/4 ) 
/******************************************************************************
 * TODO: Create a new ListNode and add it to the end of the single linked
 * 	 list. There is no check if the value exists in the list. 
 *
 * Parameters: list -- The single linked list to which you will insert the new
 * 		       ListNode to the end of.
 *             value -- The new ListNode will contain this value.
 *
 * Return: void
 * 
 * Return Type: void
 *****************************************************************************/
void llist_insert_last(LinkedList * list, int value) {
    // Write Your Code Here
    	ListNode * n = (ListNode *) malloc (sizeof(ListNode));
	ListNode * e = list->head;
	if (e == NULL) {
		llist_add(list, value);
		
	} else {
		while (e->next != NULL) {
			e = e->next;
		}
		e->next = n;
		n->next = NULL;
		n->value = value;
	}
}

// Problem ( 3/4 )
/******************************************************************************
 * TODO: Remove the ith entry from the single linked list.   	 
 * 
 * Parameters: list -- The single linked list to which you will be removing
 * 		       the listNode from.
 * 	       ith -- The index where you will remove the listNode from the
 * 	              single linked list. 
 *
 * Return: Return 1 if the ListNode is removed.
 * 	   Return 0 if the ith entry does not exist in the list or the list is
 * 	   empty.
 *
 * Return Type: integer
 *****************************************************************************/
int llist_remove_ith(LinkedList * list, int ith) {
    // Write Your Code Here
	ListNode * e = (ListNode*) malloc(sizeof(ListNode));
	ListNode * f = (ListNode*) malloc(sizeof(ListNode));

	e = list -> head;
	f = list -> head -> next;

	if(e == NULL) {
		return 0;
	}
	
	int i = 0;

	while(f != NULL) {
		i++;

		if(i == ith) {
			e -> next = f -> next;
			return 1;
		}
		e = e -> next;
		f = f -> next;
	}
	return 0;
}

// Problem ( 4/4 )
/******************************************************************************
 * TODO: Iterate through list1 and list2. Check if any values intersect between
 *       the two lists. If the values match, add the intersecting elements
 *       to list3. Use the function llist_add(LinkedList * list, int value)
 *       to add a value to the list.
 * 
 * Parameters: list1 -- singled linked list, find values that intersect with
 *                      list2
 *             list2 -- single linked list, find values that intersect with
 *                      list1
 *             list3 -- store the intersection of list1 and list2 in this list
 *
 * Return: void 
 *
 * Return Type: void
 *****************************************************************************/
int llist_exists(LinkedList * list, int value) {
	ListNode * e = (ListNode *) malloc(sizeof(ListNode));
	e = list -> head;

	if(e == NULL) {
		return 0;
	}

	while(e != NULL) {
		if(e -> value == value) {
			return 1;
		}
		e = e -> next;
	}
	return 0;
}

void llist_intersection(LinkedList * list1, LinkedList * list2,
	LinkedList * list3) {
/*
	ListNode * e = (ListNode *) malloc(sizeof(ListNode));
	ListNode * f = (ListNode *) malloc(sizeof(ListNode));

	e = list1 -> head;
	f = list2 -> head;

	while(e != NULL) {
		while(f != NULL) {
			if(e -> value == f -> value) {
				llist_add(list3, f -> value);
			}
			f = f -> next;
		}
		e = e -> next;
		f = list2 -> head;

	}
 }

 */

	ListNode * p = (ListNode *) malloc(sizeof(ListNode));
	ListNode * q = (ListNode *) malloc(sizeof(ListNode));
	ListNode * g = (ListNode *) malloc(sizeof(ListNode));
	
	for(p = list1 -> head; p != NULL; p = p -> next) {
		if(!existss(list3,p -> value)) {
			llist_insert_last(list3, p -> value);
		}
	}

	for(q = list2 -> head; q != NULL; q = q -> next) {
		if(!existss(list3, q -> value)) {
			llist_insert_last(list3, q -> value);
		}
	}
}

int existss(LinkedList * list, int value) {
	ListNode * e;
	e = list -> head;
	if(e == NULL) {
		return 0;
	}
	while(e -> next != NULL) {
		if(value == e -> value) {
			return 1;
		}
		e = e -> next;
	}
	return 0;
}
