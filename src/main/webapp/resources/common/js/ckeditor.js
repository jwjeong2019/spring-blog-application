/**
 * 
 */
ClassicEditor
        .create( document.querySelector( '#content' ) )
        .catch( error => {
            console.error( error );
        } );
//CKEDITOR.replace( 'content' );