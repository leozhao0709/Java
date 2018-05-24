# Java Version select

# 1. install different version of java

install a new version of java:

*   `brew install jenv`
*   `brew tap caskroom/versions`
*   `brew cask search java`
*   `brew cask install java8`

Select the new version:

*   `/usr/libexec/java_home -V` check javaVersionPathHere
*   `jenv add <javaVersionPathHere>`
