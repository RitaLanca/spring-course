import React, { Component } from 'react'
import { BrowserRouter, Route, Switch } from 'react-router-dom';


export default class App extends Component {
    
      render() {
        return (
          <BrowserRouter>
            <div>
              <Switch> 
                {/*use the<Switch> component to group <Route>s*/}

                <Route path="/" component={RecipeList} />
                <Route path="/recipeId" component={RecipeDetails} />
                <Route path="/new" component={RecipeForm} />
    
               
    
              </Switch>
            </div>
          </BrowserRouter>
        );
      }
    }