#include "zlib.h"
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

int main()
{
uLong test = crc32(0L, Z_NULL,0);
Bytef testbuf[]="123456789";
test = crc32(test,testbuf,9);
printf("%ld",test);
 time_t start = time(NULL);
 srand(time(NULL));
 uLong crc = crc32(0L, Z_NULL, 0);
 uLong original_crc = crc32(0L,Z_NULL,0);
 Bytef buffer[] = "19449131";
 Bytef originalbuffer[] = "00000000";
 long i = 0;
 crc = crc32(crc, buffer, 8);
while(crc != original_crc){
 int number = rand()%8;
   if(originalbuffer[number] < 'z') {
        originalbuffer[number]++;
  } else {
     originalbuffer[number] = '0';
 } 
 i++;
   original_crc = crc32(0L,Z_NULL,0);
   original_crc = crc32(original_crc, originalbuffer,8);
   
if(i%1000000 == 0){
printf("Tried %ld \n", i);
printf("random String %s \n", originalbuffer);
   
}
} 
time_t end = time(NULL);
time_t total = end - start;     
printf("Start = %ld , End = %ld, total= %ld \n",start, end, total); 
printf("the program ran, crc = %lu original = %lu , buffer = %s , originalbuffer = %s \n",crc,original_crc, buffer, originalbuffer);

return 0;
}
