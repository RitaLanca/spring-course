import { combineReducers } from 'redux';
import { reducer as formReducer } from 'redux-form';

import reducerRecipes from './Reducers/reduceRecipes';

const rootReducer = combineReducers({
    recipes:reducerRecipes,
   
  });
  
  export default rootReducer;