#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/dir.h>
#include <unistd.h>
#include <stdlib.h>
#include "dirent.h"

DIR *opendir(char *dirname)
{
        int fd;
        struct stat stbuf;
        DIR *dp;

        if((fd = open(dirname, O_RDONLY, 0)) == -1
           || fstat(fd, &stbuf) == -1
           || (stbuf.st_mode & S_IFMT) != S_IFDIR
           || (dp = (DIR *)malloc(sizeof(DIR))) == NULL) {
                return NULL;
        }
        dp->fd = fd;
        return dp;
}

void closedir(DIR *dir)
{
        if(dir) {
                close(dir->fd);
                free(dp);
        }
}

Dirent *readdir(DIR *dp)
{
        struct direct dirbuf;
        static Dirent d;

        while(read(dp->fd,&dirbuf,sizeof(dirbuf)) == sizeof(dirbuf)) {
                if(dirbuf.d_ino == 0) {
                        continue;
                }
                d.ino = dirbuf.d_ino;
                strncpy(d.name, dirbuf.d_name, DIRSIZ(dirbuf));
                d.name[DIRSIZ(dirbuf)]='\0';
                return &d;
        }

        return NULL;
}
