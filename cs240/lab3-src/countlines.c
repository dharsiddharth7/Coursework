
#include <stdio.h>
#include <stdlib.h>

int
main(int argc, char ** argv) {
	int c;
	int lines=0;
	
	printf("Program that counts lines.\n");

	char * hamlet = argv[1];
	FILE * fd = fopen(hamlet,"r");

	if(fd == NULL) {
		printf("Could not open file %s\n",hamlet);
		exit(1);
	}
 	while((c=fgetc(fd)) != EOF) {
		if(c == '\n') {
			lines++;
		}
	}

	printf("Total lines: %d\n", lines);
        fclose(fd);
}
