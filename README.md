# wall-mind-ui
The UI Library of Components used by the app Wall Mind

# WmFavouritePill

[WMFavouritePill.webm](https://github.com/zurche/wall-mind-ui/assets/15671525/986a15ad-4c1c-4592-a377-f9606d565835)

### Incorporate WmFavouritePill

In your Composable function, simply call the `WmFavouritePill` function and provide the required parameters:

- `wmWallpaper`: An instance of `WmWallpaper` that contains the current favorite state. You can create an instance with `WmWallpaper(isFavorite = false)`.

- `onFavouriteClicked`: A lambda function that will be called when the favorite button is clicked. You can handle your logic inside this function.

Here's an example of how to incorporate the `WmFavouritePill` Composable:

```kotlin
@Composable
fun MyScreen() {
    // Your existing code...

    WmFavouritePill(
        wmWallpaper = WmWallpaper(isFavorite = false),
        onFavouriteClicked = { wallpaperKey ->
            // Handle favorite button click logic here
            // Maybe update your data model or perform an action
        }
    )

    // Your existing code...
}
```

And that's it! You now have a beautiful favorite icon that flips and changes color with state changes.

## Additional Notes

- The favorite state is managed by the `isFavourite` variable inside the Composable function. You don't need to worry about managing the state externally.

- The icon used for the favorite button is determined by the `R.drawable.heart` and `R.drawable.heart_outline` resources. Make sure you have these drawable resources in your project.

- Feel free to modify the padding and shape parameters to suit your UI design.

- Remember to have fun with your users! Maybe you could consider displaying a little message like "Your users will fall in love with this feature!" after they click the favorite button. 😉

That's all you need to know to use the WmFavouritePill Composable. We hope you have a great time incorporating it into your Android project. Happy coding and spreading the love! 🥳❤️
