package me.saket.dank.utils.markdown.markwon;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.nytimes.android.external.cache3.Cache;

import org.junit.Before;
import org.junit.Test;

import ru.noties.markwon.SpannableConfiguration;

public class MarkwonBasedMarkdownRendererTest {

  private MarkwonBasedMarkdownRenderer renderer;

  @Before
  public void setUp() {
    //noinspection unchecked
    renderer = new MarkwonBasedMarkdownRenderer(mock(SpannableConfiguration.class), mock(AutoRedditLinkExtension.class), mock(Cache.class));
  }

  @Test
  public void fixInvalidTables() {
    // TODO.
  }

  @Test
  public void escapeSpacesInLinkUrls() {
    String invalid = "see [Wikipedia](http://en.wikipedia.org/wiki/Markdown)\n\n[Spoiler](/s \"text inside quotes\") [Spoiler](/s \"\") " +
        "[Spoiler](/s)\n\n*****\n\nSub: /r/pics r/pics\n\nUser: /u/Saketme/ u/saketme/\n\n*****\n\n[^Send ^feedback](https://www.reddit.com" +
        "/message/compose/?to=poochi&amp;amp;subject=New bot feedback)\n\n[spoiler](/s \"the right thing :p\")\n\n[spoiler](#s \"I will be " +
        "hanged\")\n\nEdit: fixed grammar";

    String expected = "see [Wikipedia](http://en.wikipedia.org/wiki/Markdown)\n" +
        "\n" +
        "[Spoiler](/s \"text inside quotes\") [Spoiler](/s \"\") [Spoiler](/s)\n" +
        "\n" +
        "*****\n" +
        "\n" +
        "Sub: /r/pics r/pics\n" +
        "\n" +
        "User: /u/Saketme/ u/saketme/\n" +
        "\n" +
        "*****\n" +
        "\n" +
        "[^Send ^feedback](https://www.reddit.com/message/compose/?to=poochi&amp;amp;subject=New%20bot%20feedback)\n" +
        "\n[spoiler](/s \"the right thing :p\")\n\n[spoiler](#s \"I will be hanged\")\n\nEdit: fixed grammar";

    String parsed = renderer.escapeSpacesInLinkUrls(invalid);
    assertEquals(expected, parsed);
  }

  @Test
  public void fixInvalidHeadings() {
    String invalid = "#hello This is Markdown Live Preview\\n\n" +
        "----\n" +
        "\\n\n" +
        "*****\n" +
        "\\n\n" +
        "___\n" +
        "\\n##what is Markdown?\n" +
        "\\n\\n### what is Markdown\\n";

    String expected = "# hello This is Markdown Live Preview\\n\n" +
        "----\n" +
        "\\n\n" +
        "*****\n" +
        "\\n\n" +
        "___\n" +
        "\\n## what is Markdown?\n" +
        "\\n\\n### what is Markdown\\n";

    String parsed = renderer.fixInvalidHeadings(invalid);
    assertEquals(expected, parsed);
  }

  @Test
  public void fixInvalidLinks() {
    String invalid = "[title] (url)";
    String expected = "[title](url)";

    String parsed = renderer.removeSpaceBetweenLinkLabelAndUrl(invalid);
    assertEquals(expected, parsed);
  }

  @Test
  public void fixInvalidSpoilers() {
    String invalid = "[spoiler](/s \"I will be hanged\")\n" +
        "[spoiler](# s\"I will be hanged\")\n" +
        "[spoiler](/s \"\"you will hang me.\"\")\n" +
        "[spoiler](/s \"\"\"you will hang me.\"\"\")";

    String expected = "[spoiler](/s \"I will be hanged\")\n" +
        "[spoiler](/s \"I will be hanged\")\n" +
        "[spoiler](/s \"you will hang me.\")\n" +
        "[spoiler](/s \"you will hang me.\")";

    String parsed = renderer.fixInvalidSpoilers(invalid);
    assertEquals(expected, parsed);
  }
}