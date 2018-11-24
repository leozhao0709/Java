# Java Version select

# 1. install different version of java

install a new version of java:

*   `brew install jenv` [jenv](http://www.jenv.be/)
*   add these shell to your bash_profile/zshrc

    ```shell
    export PATH="$HOME/.jenv/bin:$PATH"
    eval "$(jenv init -)"
    ```
*   go to [AdoptOpenJDK](http://jdk.java.net/) to download openJdk
*   `sudo mv ~/Downloads/[11.0.1.jdk] /Library/Java/JavaVirtualMachines`
*   use `/usr/libexec/java_home -V` to check what you have in java. 
*   use `jenv add /Library/Java/JavaVirtualMachines/11.0.1.jdk/Contents/Home`


Note:

-   You can use `/usr/libexec/java_home -V` to check what you have in java. But that's not the `jenv` added version.
-   Use `jenv versions` to check what java version you have in current system
-   Use `jenv global openjdk64-11.0.1` to configure global java version
-   Use `jenv local openjdk64-11.0.1` to set local java version(directory level)
