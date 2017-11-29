import axios from 'axios';
import { SERVER_URL } from '../utils/GlobalConstants';





//Recipe list
export const FETCH_RECIPES = 'FETCH_RECIPES';
export const FETCH_RECIPES_SUCCESS = 'FETCH_RECIPES_SUCCESS';
export const FETCH_RECIPES_FAILURE = 'FETCH_RECIPES_FAILURE';

//Create new recipe
export const CREATE_RECIPE = 'CREATE_RECIPE';
export const CREATE_RECIPE_SUCCESS = 'CREATE_RECIPE_SUCCESS';
export const CREATE_RECIPE_FAILURE = 'CREATE_RECIPE_FAILURE';
export const NEW_RECIPE_RESET = 'NEW_RECIPE_RESET';

//Validate recipes fields like Name, Author, Categories on the server
export const VALIDATE_RECIPES_FIELDS = 'VALIDATE_RECIPES_FIELDS';
export const VALIDATE_RECIPES_FIELDS_SUCCESS = 'VALIDATE_RECIPES_FIELDS_SUCCESS';
export const VALIDATE_RECIPES_FIELDS_FAILURE = 'VALIDATE_RECIPES_FIELDS_FAILURE';

//Fetch recipe
export const FETCH_RECIPE = 'FETCH_RECIPE';
export const FETCH_RECIPE_SUCCESS = 'FETCH_RECIPE_SUCCESS';
export const FETCH_RECIPE_FAILURE = 'FETCH_RECIPE_FAILURE';
export const RESET_ACTIVE_RECIPE = 'RESET_ACTIVE_RECIPE';

//Delete recipe
export const DELETE_RECIPE = 'DELETE_POST';
export const DELETE_RECIPE_SUCCESS = 'DELETE_RECIPE_SUCCESS';
export const DELETE_RECIPE_FAILURE = 'DELETE_RECIPE_FAILURE';
export const RESET_DELETED_RECIPE = 'RESET_DELETED_RECIPE';


//Recipe list Action Creators
export function fetchRecipes() {
    const request = axios.get({SERVER_URL, headers: [] });
  
    return {
      type: FETCH_RECIPES,
      payload: request
    };
  }


  export function fetchRecipesSuccess(recipes) {
    return {
      type: FETCH_RECIPES_SUCCESS,
      payload: recipes
    };
  }
  
  export function fetchPostsFailure(error) {
    return {
      type: FETCH_RECIPES_FAILURE,
      payload: error
    };
  }

//Create new recipe Actions Creators
  export function createRecipe(recipe, authorId, successCallback, failedCallback) {
    const request = axios.post(SERVER_URL + '/recipe/add', recipe, {params:authorId} );
  
    return {
      type: CREATE_RECIPE,
      payload: request
    };
  }
  
  export function createRecipeSuccess(newRecipe) {
    return {
      type: CREATE_RECIPE_SUCCESS,
      payload: newRecipe
    };
  }
  
  export function createRecipeFailure(error) {
    return {
      type: CREATE_RECIPE_FAILURE,
      payload: error
    };
  }
  
  export function newRecipeReset() {
   
    return {
      type: NEW_RECIPE_RESET,
    };
  }
    
//Fetch recipe Actions Creators
  export function fetchRecipe(id) {
    const request = axios.get(SERVER_URL + `/recipe/${id}`);
  
    return {
      type: FETCH_RECIPE,
      payload: request
    };
  }
  
  
  export function fetchRecipeSuccess(activeRecipe) {
    return {
      type: FETCH_RECIPE_SUCCESS,
      payload: activeRecipe
    };
  }
  
  export function fetchRecipeFailure(error) {
    return {
      type: FETCH_RECIPE_FAILURE,
      payload: error
    };
  }
  
  //Delete recipes
  export function deleteRecipe(id) {
    const request = axios({
      method: 'delete',
      url: SERVER_URL +` /${id}`,
    });
    return {
      type: DELETE_RECIPE,
      payload: request
    };
  }
  
  export function deleteRecipeSuccess(deletedRecipe) {
    return {
      type: DELETE_RECIPE_SUCCESS,
      payload: deletedRecipe
    };
  }
  
  export function deleteRecipeFailure(response) {
    return {
      type: DELETE_RECIPE_FAILURE,
      payload: response
    };
  }

   //Validate recipes
   export function validateRecipeFields(props) {
     //note: we cant have /recipes/validateFields because it'll match /posts/:id path!
    const request = axios.post(SERVER_URL + `/posts/validate/fields`,props);
    return {
      type: VALIDATE_RECIPES_FIELDS,
      payload: request
    };
  }
  
  export function validateRecipeFieldsSuccess() {
    return {
      type: VALIDATE_RECIPES_FIELDS_SUCCESS,
    };
  }
  
 
  
  