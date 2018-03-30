# SteemStone is a Cardgame in Steemit..!!
## Details

### Game description
***Steemstone*** is a game in which cards are played against each other similar to "HearthStone".
The game is divided into two camps, and a card deck is created on each side to fight against each other. There are two types of games: cooperation and mini games.


#### Cooperation
Create camp postings to make your favorite camp stronger.
A voter can buy a unit or spell through boarding a favorite camp.
Complete the deck by listing the spells or units purchased.
Duel with your opponent's deck and win the battle with the remaining cards.

#### Mini Game
Create a separate page to fight the 1: 1 game.
We will implement it so that we can give compensation to those who win and win the SBD.


<br>

### Cards are divided into two types: units and magic.


#### Unit
There are units for each camp.
Units have level, attack, health, range, attack type, and special abilities.
Depending on the level difference, the abilities and special abilities will give good performance.
Depending on the level, the amount used to purchase is set differently.


#### Magic
There is magic on each side.
The magic is divided into attack magic, recovery magic, and support magic.

#### Battle
The unit and the magic deck are listed sequentially, and the battle between the faction determines the victory and defeat.

   
___
## Components
### Back-End

#### Framework
	springBoot(Version 1.5.7)

#### Dependencies
	compile('org.springframework.boot:spring-boot-starter-mobile')
	compile('org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.1')
	compile('org.springframework.boot:spring-boot-starter-security')
	compile('org.springframework.session:spring-session')
	compile('org.springframework.boot:spring-boot-starter-thymeleaf')
	compile('org.springframework.boot:spring-boot-starter-web')
	compile('org.springframework.boot:spring-boot-starter-web-services')
	compile('com.googlecode.json-simple:json-simple:1.1.1')
	compile group: 'org.json', name: 'json', version: '20090211'
	compile('com.google.code.gson:gson:2.7')
	compile group: 'org.mariadb.jdbc', name: 'mariadb-java-client', version: '2.1.1'
	compile group: 'org.apache.commons', name: 'commons-collections4', version: '4.0'
	compile group: 'org.apache.commons', name: 'commons-lang3', version: '3.0'
	compile group: 'eu.bittrade.libs', name: 'steemj-core', version: '0.4.3'
	providedRuntime('org.springframework.boot:spring-boot-starter-tomcat')
	testCompile('org.springframework.boot:spring-boot-starter-test')
	testCompile('org.springframework.security:spring-security-test')
	




### Front-End
	ReactJs(Version XX)
	
It consists of a separate web page.
You can check the current faction information and check the battle results.
SteemConnect will work with SteepConnect in a separate page.
The page will be created with React.



___
## Deadline
### Back-End
Last day of May, 2018

### Front-End
Last day of May, 2018

### Separate interlocking webpages
Last day of August, 2018

### Game Graphics
Last day of December, 2018

### The cards will continue to be added.


___

## Communication
Please send E-Mail to us.
## steemgameland@gmail.com
