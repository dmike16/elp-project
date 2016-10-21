#include "syscall.h"

int main(int argc, char* argv[])
{
  char buf[BUFFSIZE];
  int n;
  int getchar(void);
  int getchar_buffered(void);

  while((n = getchar_buffered()) > 0){
    write(1,&n,1);
  }
  return 0;
}

int getchar()
{
  char c;

  return (read(0,&c,1) == 1)? (unsigned char) c: EOF;
}

int getchar_buffered()
{
  static char buf[BUFFSIZE];
  static char *bufp=buf;
  static int n  = 0;

  if( n == 0){
    n = read(0,buf,sizeof buf);
  }
  return (--n >= 0) ? (unsigned char) *bufp++: EOF;
}
