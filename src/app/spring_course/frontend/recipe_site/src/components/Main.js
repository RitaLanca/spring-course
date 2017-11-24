import { Switch, Route } from 'react-router-dom';


const Main = () => (
  <main>
    <Switch>
      <Route exact path='/' component={RecipeList}/>
      <Route path='/recipeId' component={RecipeDetails}/>
      <Route path='/new' component={RecipeForm}/>
    </Switch>
  </main>
)