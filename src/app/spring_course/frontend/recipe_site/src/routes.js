import React from 'react';
import { Route, IndexRoute } from 'react-router';

import App from './pages/App';
import PostsIndex from './pages/PostsIndex';
import PostsNew from './pages/PostsNew';
import PostsShow from './pages/PostsShow';


export default (
  <Route path="/" component={App}>
    <IndexRoute component={RecipesIndex} />
    <Route path="recipes/new" component={RecipeForm} />
    <Route path="recipes/:id" component={RecipeDetails} />
  </Route>
);
