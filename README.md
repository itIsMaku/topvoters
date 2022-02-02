# TopVoters
RestAPI for getting top voters from Czech-Craft.eu and CraftList.org.

## Czech-Craft.eu
Required informations:
| Information    | Description | Example |
|------------|---------|---------|
| SERVER-SLUG | Name of server on https://czech-craft.eu | matherioneu |
| MONTH  | Month in year | 11 (November)   |
| YEAR  | Year | 2 |

These informations just put here: `http://localhost:8080/v1/czech-craft/SERVER-SLUG/MONTH/YEAR/`.  
Example: `http://localhost:8080/v1/czech-craft/matherion/1/2022/`

## CraftList.org
Required informations:
| Information    | Description | Example |
|------------|---------|---------|
| SERVERAPITOKEN | API key from server edit page https://craftlist.org | HIDDEN |
| MONTH | Month in year | 11 (November) |
| YEAR  | Year | 2 |

These informations just put here: `http://localhost:8080/v1/craftlist/SERVERAPITOKEN/MONTH/YEAR/`.   
Example: `http://localhost:8080/v1/craftlist/HIDDEN/1/2022/`
