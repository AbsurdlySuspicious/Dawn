package me.saket.dank.mock

import me.saket.dank.walkthrough.SyntheticSubmission


class MarkdownTest : SyntheticSubmission(0, "Markdown test") {
  companion object {
    fun post(): MockPost = MockPost(MarkdownTest(), emptyList())
  }

  override fun isSelfPost(): Boolean = true
  override fun getSelfText(): String? = """
    # title
    
    ## generic
    
    ~~strikethrough~~ *italic* **bold**
    
    ## links
    
    ordinary https://i.imgur.com/NaWfFWR.jpg link
    
    link https://i.imgur.com/NaWfFWR.jpg#anchor with anchor

    link with [text](https://i.imgur.com/NaWfFWR.jpg) and here after too
    
    in[middle](https://i.imgur.com/NaWfFWR.jpg)of text
    
    [escaped\_underscore](reddit.com)
    
    [just_underscore](reddit.com)
    
    * **lib.rs**: [https://lib.rs/crates/fwd\_ad](https://lib.rs/crates/fwd_ad)
    * **gitlab**: [https://gitlab.inria.fr/InBio/Public/fwd\_ad](https://gitlab.inria.fr/InBio/Public/fwd_ad)
    * **crates.io**: [https://crates.io/crates/fwd\_ad](https://crates.io/crates/fwd_ad)
    * **docs.rs**: [https://docs.rs/fwd\_ad/0.2.0/fwd\_ad/](https://docs.rs/fwd_ad/0.2.0/fwd_ad/)
    
    ## linefeeds
    
    two spaces  
    linefeed
    
    no linefeed
    here
    
    ## monospace
    
    some `inline monospace` regular
    
    ```
    fenced
    code block
    ```
    
        4 spaces
        code
        block

    	tabbed
    	code
    	block

    same but separated

        4 spaces
        code
        block

    ---

    	tabbed
    	code
    	block
        
    ## spoilers
    
    spoiler without spaces >!spoiler!<
    
    spoiler with spaces >! spoiler !<
    
    >!usual spoiler!< in beginning
    
    >! usual spoiler !< same with spaces
    
    spoiler /s [square braces (lowercase UPPERCASE)](/s "the spoiler")
    
    spoiler /spoiler [square braces](/spoiler "the spoiler")
    
    spoiler empty squares /s [](/s "the spoiler")
    
    ## superscript
    
    superscript^1st^2nd^3rd
    
    superscript^(with braces)^(2 / second)
    
    just smiley ^_^
    
    escaped smiley \^_\^
    
    with spaces ^ _ ^
    
    space here ^after sup
    
    same ^(with braces)
    
    ## quotes
    
    > ! quote with bang
    
    > next quote
    next line
    
    > next quote
    > next line with gt
    
    ## tables
    
    Column L | Column C | Column R
    :--------|:--------:|---------:
    A1 | B1 | C1
    A2 | B2 | C2 

  """.trimIndent() +
      "Hi everyone,\n\n[**Fwd:AD**](https://lib.rs/crates/fwd_ad) is a Rust crate to perform [forward auto-differentiation](https://en.wikipedia.org/wiki/Automatic_differentiation#Automatic_differentiation_using_dual_numbers), with a focus on empowering its users to manage memory location and minimize copying. It is made with the goal of being useful and used, so documentation and examples are considered as important as code during development. Its key selling-points are:\n\n1. **Clone-free** by default. Fwd:AD will never clone memory in its functions and `std::ops` implementations, leveraging Rust's ownership system to ensure correctness memory-wise, and leaving it up to the user to be explicit as to when cloning should happen.\n2. **Automatic cloning** on demand. If passed the `implicit-clone` feature, Fwd:AD will implicitly clone when needed. Deciding whether to clone or not is entirely done via the type-system, and hence at compile time.\n3. **Generic in memory location**: Fwd:AD's structs are generic over a container type, allowing them to be backed by any container of your choice: `Vec` to rely on the heap, arrays if you're more of a stack-person, or other. For example, it can be used with `&amp;mut [f64]` to allow an FFI API that won't need to copy memory at its frontier.\n\nI've been working on it for the last months and I think it is mature enough to be shared.\n\nI am very eager to get feedback and to see how it could be used by the community so please share any comment or question you might have.\n\n* **lib.rs**: [https://lib.rs/crates/fwd\\_ad](https://lib.rs/crates/fwd_ad)\n* **gitlab**: [https://gitlab.inria.fr/InBio/Public/fwd\\_ad](https://gitlab.inria.fr/InBio/Public/fwd_ad)\n* **crates.io**: [https://crates.io/crates/fwd\\_ad](https://crates.io/crates/fwd_ad)\n* **docs.rs**: [https://docs.rs/fwd\\_ad/0.2.0/fwd\\_ad/](https://docs.rs/fwd_ad/0.2.0/fwd_ad/)\n\nThanks to all the Rust community for helping me during the development, you made every step of it enjoyable."
}
