1. Bump version numbers in all xml-files:
   - In eu.hohenegger.indentationtree.releng execute:
      $ mvn -Dtycho.mode=maven org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=1.2.3.4
   - In eu.hohenegger.indentationtree.p2update/category.xml remove feature with old version and add feature with new version (1.2.3.4)
2. Run 'mvn clean install' from within releng-repository
3. Find repository-folder in p2updatesite-project
4. Commit changes
5. Deploy: 'mvn install -P uploadRepo'



If necessary copy settings.xml to ${user.home}/.m2/settings.xml:
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <localRepository/>
  <interactiveMode/>
  <usePluginRegistry/>
  <offline/>
  <pluginGroups/>
  <mirrors/>
  <proxies>
    <proxy>
      <active>true</active>
      <protocol>http</protocol>
      <host>host</host>
      <port>port</port>
    </proxy>
  </proxies>

  <servers>
    <server>
      <id>p2Repo</id>
      <username>user</username>
      <password>password</password>
    </server>
  </servers>
  
  <profiles/>
  <activeProfiles/>
</settings>