1. Bump version numbers in all xml-files:
   - In eu.hohenegger.indentationtree.releng execute:
      $ mvn -Dtycho.mode=maven org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=1.2.3.4
   - In eu.hohenegger.indentationtree.p2update/category.xml remove feature with old version and add feature with new version (1.2.3.4)
2. Copy settings.xml to ${user.home}/.m2/settings.xml
3. Run 'mvn clean install' from within releng-repository
4. Find repository-folder in p2updatesite-project
5. Commit changes
6. Deploy: 'mvn install -P uploadRepo'