package org.dstadler.jgit.porcelain;

import oracle.jgit.Utils;
import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.List;


public class PorcelainTest {

    @Test
    public void runSamples() throws Exception {
        Utils.setProxy();

        // simply call all the samples to see any severe problems with the samples
        AddAndListNoteOfCommit.main(null);
        AddFile.main(null);
        BlameFile.main(null);
        CheckoutGitHubPullRequest.main(null);
        CleanUntrackedFiles.main(null);
        CloneRemoteRepository.main(null);
        // does not run without changes: CloneRemoteRepositoryWithAuthentication.main(null);
        // TODO: sometimes fails because there are still files open?!: CollectGarbage.main(null);
        CommitAll.main(null);
        CommitFile.main(null);
        CreateAndDeleteBranch.main(null);
        CreateAndDeleteTag.main(null);
        CreateArchive.main(null);
        CreateCustomFormatArchive.main(null);
        CreateListApplyAndDropStash.main(null);
        DiffFilesInCommit.main(null);
        DiffRenamedFile.main(null);
        FetchRemoteCommits.main(null);
        FetchRemoteCommitsWithPrune.main(null);
        InitRepository.main(null);
        ListBranches.main(null);
        ListNotes.main(null);
        ListRemoteRepository.main(null);
        ListRemotes.main(null);
        ListTags.main(null);
        ListUncommittedChanges.main(null);
        MergeChanges.main(null);
        RebaseToOriginMaster.main(null);
        RevertChanges.main(null);
        RevertCommit.main(null);
        ShowBlame.main(null);
        ShowBranchDiff.main(null);
        ShowChangedFilesBetweenCommits.main(null);
        ShowFileDiff.main(null);
        ShowLog.main(null);
        ShowStatus.main(null);
        WalkAllCommits.main(null);
    }
}
