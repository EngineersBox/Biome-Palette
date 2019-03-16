# BlockPalette
<img src="https://media.forgecdn.net/avatars/186/491/636834062293308662.png" width=100px height=100px>

## Features
This plugin allows players to view biome specific textures of blocks within a GUI. The GUI is navigable as the textures are classified by biome, via page format. The textures are dependant on the CTM section within a resource pack (requires optifine). The other features of this plugin are; the ability change the biome of a specific block or change a specific biome to another within a given area, get the location of a selected chunk and get the location of a selected block (both in X, Z terms).

The main menu of the GUI:\
![GUI Main Menu](https://i.ibb.co/pJ2twDN/main-menu.png)

Plains tab of the GUI:\
![Plains Tab](https://i.ibb.co/kG2XyYH/plains-menu.png)

---

## Commands

* **/bp** - *Opens the block palette for biome specific textures*
* **/bp help** - *displays all help options*
* **/bp tool** - *Gives the block biome tool*
* **/bp setBiome \<biome\>** - *Sets the biome tool biome*
* **/bp getbiome \<enable/disable\>** - *Changes tool to identify biome of a selected block*
* **/bp areareplace \<enable/disable\>** - *Enables Replacing Specific Biome To Another Within Area Selection Made With /bp tool*
* **/bp replaceto \<from\> \<to\>** - *Specifies Biomes To Swap In Area Selection*
* **/bp undo** - *Reverts Last Tool Usage*
* **/bp biomelist** - *Displays all valid biomes*
* **/bp chunkinfo \<enable/disable\>** - *Displays chunk data when using /bp tool*
* **/bp settings** - *View the active settings for /bp getbiome and /bp chunkinfo*
* **/bp add \<biome\> \<block\> \<name\>** - *Adds a block to the block palette GUI, given via arguments*
* **/bp remove \<biome\> \<block\> \<name\>** - *Removes a block from the block palette GUI, given via arguments*
* **/bp version** - *Displays the plugin version information*
* **/bp reload** - *Reloads the plugin*


---

## Permissions

* **bp.\* ** - *Gives access to all BlockPalette commands*
* **bp.open** - *Gives access to GUI*
* **bp.help** - *Gives access to help section*
* **bp.tool** - *Gives access to biome tool*
* **bp.setbiome** - *Gives access to configuring tool biome*
* **bp.getbiome** - *Gives access to view block biome*
* **bp.areareplace** - *Replaces Specific Biome To Another Within Area Selection*
* **bp.replaceto** - *Specifies Biomes To Swap In Area Selection*
* **bp.undo** - *Returns Most Recent Biome Replacement from /bp areareplace To Original Biome*
* **bp.biomelist** - *Gives access to view valid biomes*
* **bp.chunkinfo** - *Gives access to view active chunk for tool*
* **bp.settings** - *Gives access to view getbiome and chunkinfo settings*
* **bp.add** - *Gives access to add blocks to the GUI*
* **bp.remove** - *Gives access to remove blocks from the GUI*
* **bp.version** - *Gives access to view the plugin version information*
* **bp.reload** - *Gives access to reload the plugin*

---

## Configuration and Installation

Drag and drop the most recent version of the plugin into your plugins folder. Restart or start the server, the config file will generate.

The config file contains:

> plains: ''\
> desert: ''\
> ocean: ''\
> forest: ''\
> savanna: ''\
> taiga: ''\
> extremehills: ''

Here you can:
* manually add blocks to the GUI sections
* view the currently added ones. (note that invalid syntax via manual addition will result in the block not being added)

---