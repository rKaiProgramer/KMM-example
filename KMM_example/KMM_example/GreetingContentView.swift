import SwiftUI
import shared
struct GreetingContentView: View {
    let greet = Greeting().greeting()

    var body: some View {
        VStack(spacing: 20) {
            Text(greet).font(.system(size: 30)).bold()
            Spacer()
        }
    }

}
