package me.saket.dank.mock

import me.saket.dank.ui.submission.SubmissionAndComments
import me.saket.dank.utils.Optional
import net.dean.jraw.models.Comment
import net.dean.jraw.models.Listing
import net.dean.jraw.models.NestedIdentifiable
import net.dean.jraw.models.Submission
import net.dean.jraw.tree.CommentTreeSettings
import net.dean.jraw.tree.RootCommentNode

class MockPost(
    val submission: Submission,
    val comments: List<Comment>
) {
  fun toRealPost(): SubmissionAndComments {
    val commentsListing = Listing.create(null, comments as? List<NestedIdentifiable>)
    val rootCommentNode = RootCommentNode(submission, commentsListing,
        CommentTreeSettings(submission.id, submission.suggestedSort!!))
    return SubmissionAndComments(submission, Optional.of(rootCommentNode))
  }
}

class MockPostList {
  val list = HashMap<String, MockPost>()
  init {
    list.put("syntheticsubmission_markdown_test", MarkdownTest.post());
  }
}
