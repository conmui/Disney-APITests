## Disney API Testing

This project contains API automation tests for the [Disney API](https://disneyapi.dev/), implemented using Java, Rest Assured, and Hamcrest for assertions. 

The tests cover various API endpoints related to character data, including retrieving all characters, fetching a specific character by ID, filtering characters by multiple parameters, and testing pagination functionality across multiple pages.

## Test cases

GetAllCharactersTest
- getAllCharacters_fields()

GetOneCharacterTest
- getOneCharacterByEndpointId_character()
- getOneCharacterByEndpointInvalidId_noMatchEmpty()

FilterCharactersTest
- filterCharacterByName_character()
- filterCharacterByName_characters()
- filterCharacterByNameAndFilm_character()
- filterCharacterByInvalidName_noMatchEmpty()

PaginationTest
- pagination_prevNumNextNum()
- paginationFirstPage_prevNullNextNum()
- paginationLastPage_prevNumNextNull()