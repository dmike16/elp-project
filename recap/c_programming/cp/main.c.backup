#include "cp.h"
#include <stdlib.h>
#include <stdarg.h>

static void error(char *fmt,...)
{
  va_list args;

  va_start(args, fmt);
  fprintf(stderr, "error: ");
  vfprintf(stderr, fmt, args);
  fprintf(stderr, "\n");
  va_end(args);
  exit(1);
}

int main(int argc,char *argv[])
{
  int f1,f2,n;
  char buf[BUFFSIZE];

  if(argc != 3){
    error("USAGE: cp from to ");
  }
  if((f1 = open(argv[1], O_RDONLY, 0))==-1){
    error("cp: can't open %s",argv[1]);
  }
  if((f2 = creat(argv[2], 0666))==-1){
    error("cp_can't open %s",argv[2]);
    close(f1);
  }
  while((n = read(f1, buf, BUFFSIZE)) > 0){
    if(write(f2, buf, n) != n){
      error("cp: write error on file %s",argv[2]);
    }
  }
  return 0;
}
