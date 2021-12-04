# TopVoters
RestAPI for getting top voters from Czech-Craft.eu and CraftList.org.

## Czech-Craft.eu
Required informations:
| Information    | Example |
|------------|---------|
| SERVER-SLUG    | matherioneu   |
| MONTH  | 11 (november)   |

**SERVER-SLUG** - Name of server on https://czech-craft.eu.   
**MONTH** - Month of year

These informations just put here: http://localhost:8080/v1/czech-craft/SERVER-SLUG/MONTH/.  
Example: http://localhost:8080/v1/czech-craft/matherion/11/

## CraftList.org
Required informations:
| Information    | Example |
|------------|---------|
| SERVERAPITOKEN    | HIDDEN   |
| MONTH  | 11 (november)   |

**SERVERAPITOKEN** - It's on the end of Edit Server page on https://craftlist.org   
**MONTH** - Month of year

These informations just put here: http://localhost:8080/v1/craftlist/SERVERAPITOKEN/MONTH/.  
Example: http://localhost:8080/v1/craftlist/HIDDEN/11/
