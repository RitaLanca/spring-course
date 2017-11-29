import {
	FETCH_POSTS, FETCH_POSTS_SUCCESS, FETCH_POSTS_FAILURE, 
	FETCH_POST, FETCH_POST_SUCCESS,  FETCH_POST_FAILURE,
	CREATE_POST, CREATE_POST_SUCCESS, CREATE_POST_FAILURE,
	DELETE_POST, DELETE_POST_SUCCESS, DELETE_POST_FAILURE,
  VALIDATE_POST_FIELDS,VALIDATE_POST_FIELDS_SUCCESS, VALIDATE_POST_FIELDS_FAILURE,
} from '../actions/recipesActions';





const INITIAL_STATE = { recipeList: {recipes: [], error:null, loading: false},  
                        newRecipe:{recipe:null, error: null, loading: false}, 
                        activeRecipe:{recipe:null, error:null, loading: false}, 
                        deletedRecipe: {recipe: null, error:null, loading: false},
                    };

export default function (state = initialState, action) {
    
        switch (action.type) {

            case recipesActions.FETCH_RECIPES:// start fetching recipes and set loading = true
                return { ...state, recipeList: {recipes: [], error:null, loading: true}
                   
                };
            case recipesActions.FETCH_POSTS_SUCCESS: // return list recipes and make loading = false
                return { ...state, recipeList: {recipes: action.payload, error:null, loading: false}
                };
            case recipesActions.FETCH_POSTS_FAILURE: // return error and make loading = false
                error = action.payload
                return { ...state,  recipeList: {recipes:  [], error:error, loading: false}
                   
                };


            case recipesActions.FETCH_RECIPE:// start fetching recipes and set loading = true
                return { ...state, activeRecipe:{...state.activeRecipe, loading: true}
                   
                };
            case recipesActions.FETCH_RECIPE_SUCCESS: // return list recipes and make loading = false
                return { ...state, activeRecipe: {recipe: action.payload, error:null, loading: false}
            
                };
            case recipesActions.FETCH_RECIPE_FAILURE: // return error and make loading = false
                error = action.payload
                return  { ...state, activeRecipe: {recipe: null, error:null, loading: false}
                   
                };


            case recipesActions.CREATE_RECIPE:// start fetching recipes and set loading = true
                return { ...state,newRecipe:{...state.newRecipe, loading: true}
                   
                };
            case recipesActions.CREATE_RECIPE_SUCCESS: // return list recipes and make loading = false
                return { ...state, newRecipe: {recipe: action.payload, error:null, loading: false}
                };
            case recipesActions.CREATE_RECIPE_FAILURE: // return error and make loading = false
                error = action.payload
                return { ...state,  newRecipe: {recipe:  null, error:error, loading: false}
                   
                }; 
                
                
            case DELETE_RECIPE:
                return {...state, deletedRecipe: {...state.deletedRecipe, loading: true}}
            case DELETE_RECIPE_SUCCESS:
               return {...state, deletedRecipe: {recipe:action.payload, error:null, loading: false}}
            case DELETE_RECIPE_FAILURE:
               error = action.payload || {message: action.payload.message};//2nd one is network or server down errors
               return {...state, deletedRecipe: {recipe:null, error:error, loading: false}}
          


            case VALIDATE_RECIPE_FIELDS:
               return {...state, newRecipe:{...state.newRecipe, error: null, loading: true}}
            case VALIDATE_RECIPE_FIELDS_SUCCESS:
               return {...state, newRecipe:{...state.newRecipe, error: null, loading: false}}
            case VALIDATE_RECIPE_FIELDS_FAILURE:
               let result = action.payload;
               if(!result) {
                 error = {message: action.payload.message};
               } else {
                 error = {name: result.name, description: result.description, servings: result.servings};
               }
               return {...state, newRecipe:{...state.newRecipe, error: error, loading: false}}
                  
            default:
                return state;
        }
    }