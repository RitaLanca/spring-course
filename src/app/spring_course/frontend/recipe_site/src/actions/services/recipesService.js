import axios from 'axios';
import { SERVER_URL } from '../../utils/GlobalConstants';

/**Serviço que recebendo um seachName efectua um GetMapping(value="/recipe/searchByName")
 * retornando a informação de todos os PublishedPosts não eliminados com publishStatus=PUBLISHED da equipa em caso de successo senão retorna errors
 * @param recipeName
 * @param successCallback response: List<ContentDTO>
 * @param failedCallback error: List<String> errors 
 */

export const requestRecipeService = function (recipeName, successCallback, failedCallback) {
    axios.get(SERVER_URL + '/recipe/searchByName', {params:{ recipeName: recipeName}} )
        .then((response) => {
            if (response.data.success) successCallback(response.data);
            else (failedCallback(response.data.errors));
          }
          );
}
