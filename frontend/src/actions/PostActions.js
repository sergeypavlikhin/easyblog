import * as types from "../constants/ActionTypes";

export function addPosts(posts) {
    return {
        type: types.ADD_POSTS,
        data: posts
    };
}

export function removePost(id) {
    return {
        type: types.REMOVE_POST,
        id: id
    };
}