# Java Version select

# 1. install different version of java

install a new version of java:

*   `brew install jenv`
*   `brew tap caskroom/versions`
*   `brew cask search java`
*   `brew cask install java8`
*   add these shell to your bash_profile/zshrc

    ```shell
    if which jenv >/dev/null; then eval "$(jenv init -)"; fi
    export JENV_ROOT=/usr/local/opt/jenv
    ```

Select the new version:

*   `/usr/libexec/java_home -V` check javaVersionPathHere
*   `jenv add <javaVersionPathHere>`
