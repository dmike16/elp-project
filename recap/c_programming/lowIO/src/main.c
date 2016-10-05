#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <time.h>

char* get_timestamp()
{
        time_t now = time(NULL);
        return ctime(&now);
}

int main(int argc, char const *argv[]) {
        const char * path = argv[1];
        char* timestamp = get_timestamp();
        mode_t mode = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH;

        int fd = open(path,O_WRONLY | O_APPEND | O_CREAT,mode);
        if(fd == -1) {
                perror("open");
                return 1;
        }
        write(fd, timestamp, strlen(timestamp));
        close(fd);
        return 0;
}
