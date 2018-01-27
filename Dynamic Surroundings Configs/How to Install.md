## 1.7.10 Version:

1. Download Latest Config file (labeled extraplanets_biomes(Latest Versions, 1.7+).json)
2. Rename json file to extraplanets_biomes.json
3. Move json file to \config\dsurround\ folder
4. Open Dynamic Surroundings Config file
5. Add the json file to this config option
```
biomes {
    # Configuration files for configuring Biome Registry [default: ]
    S:"Config Files" <
     >
```

so it looks like 
```
biomes {
    # Configuration files for configuring Biome Registry [default: ]
    S:"Config Files" <
      extraplanets_biomes.json
     >
```
6. Load the game, and enjoy :D

## 1.8+ Version:

1. Download Latest Config file (labeled extraplanets_biomes(Latest Versions, 1.7+).json)
2. Rename json file to extraplanets_biomes.json
3. Move json file to \config\dsurround\ folder
4. Open Dynamic Surroundings Config file
5. Add the json file to this config option S:"External Configuration Files"

so it looks like 
```
# Configuration files for customization [default: ]
    S:"External Configuration Files" <
        extraplanets_biomes.json
     >
```
6. Load the game, and enjoy :D
