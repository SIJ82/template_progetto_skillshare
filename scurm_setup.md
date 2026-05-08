# Loanly

A simple example repo for a SCRUM project.
The objective is to create a mobile app for borrowing items inside a school or office. 
Think “library, but for everyday stuff” — chargers, HDMI adapters, books, meeting-room kits, board games, tools.

This repo and its correspoding project have been set up as described below.

https://github.com/DavideRossi/Loanly/
# GitHub Scrum Workflow for Small Student Teams

This guide uses:

```text id="nqz7jp"
One GitHub repository
One GitHub Project
Real GitHub issues
Labels
Project fields
Pull requests
```

---

## 1. Basic idea

Use GitHub artifacts like this:

```text id="7jprmg"
Product Backlog Issue = story, bug report, chore, or other requested product change
Sprint task issue = concrete work selected for the sprint
Label = issue classification, such as ready, story, bug, chore, task
Project field = planning metadata, such as Status, PO Rank, Sprint, Estimate
Pull request = code change
```

The **Product Backlog** contains desired product changes.

The **Sprint Backlog** contains concrete work selected for the sprint.

Examples:

```text id="97ob8c"
Story PBI:
“As a user, I want to reset my password”
→ Sprint task: “Make the acceptance tests for #12 pass”

Bug PBI:
“Password reset email contains an invalid link”
→ Sprint task: “Fix the invalid password reset link bug described in #18”

Chore PBI:
“Add CI pipeline”
→ Sprint task: “Set up GitHub Actions CI for build and tests”
```

---

## 2. Create the repository and invite teammates

One student creates the repository.

Then:

1. Open the repository on GitHub.
2. Click **Settings**.
3. Click **Collaborators** or **Collaborators and teams**.
4. Click **Add people**.
5. Invite the other team members.

All team members should be able to create issues, edit the Project, create branches, and open pull requests.

---

## 3. Create a Project

1. Click your GitHub profile picture.
2. Go to **Your projects**.
3. Click **New project**.
4. Choose **Table**.
5. Name it, for example:

```text id="yozuc3"
Sample App Scrum Board
```

---

## 4. Link the Project to the repository

From the repository:

1. Open the repository.
2. Click **Projects**.
3. Click **Link a project**.
4. Select your Project.

Inside the Project settings, also set:

```text id="da6ron"
Default repository = your group repository
```

This helps when creating new issues from the Project.

---

## 5. Create labels

In the repository:

1. Open **Issues**.
2. Click **Labels**.
3. Create these labels:

```text id="s5p2z2"
ready
story
bug
chore
task
```

Meaning:

```text id="79g64q"
ready = Product Backlog Issue is clear enough for sprint planning
story = user-facing feature or behavior
bug = defect to fix
chore = technical or maintenance work
task = sprint execution work
```

Only issues with the `ready` label may be selected during sprint planning.

---

## 6. Create Project fields

In the Project table:

1. Click **View**.
2. Open **Fields**.
3. Add or enable these fields:

```text id="987dtf"
Status      Single select
PO Rank     Number
Sprint      Iteration
Estimate    Number
Priority    Single select
Assignees   Built-in field
Labels      Built-in field
```

Use these `Status` values:

```text id="s679re"
Product backlog
Sprint backlog
In progress
Blocked
Done
```

Use these `Priority` values:

```text id="1u36z4"
Low
Medium
High
```

If a field exists but is hidden, use **View → Fields** to show it in the current view.

---

## 7. Use one shared table view

Keep one main table view called:

```text id="w5gicc"
Project Table
```

This is the shared planning workspace for the whole team.

Recommended visible columns:

```text id="xqmled"
Title
Status
Labels
PO Rank
Sprint
Estimate
Priority
Assignees
```

Recommended table ordering:

```text id="sogq4n"
Sort by Status
Then sort Product backlog items by PO Rank
```

The Product Owner owns the ordering of backlog items, but the whole team can see and discuss the table.

---

## 8. Create a Project Board view

Create a second view:

1. Open the Project.
2. Create a new view.
3. Choose **Board** layout.
4. Name it:

```text id="xwazlt"
Project Board
```

Group the board by the `Status` field.

Use these columns:

```text id="2vxvy6"
Product backlog
Sprint backlog
In progress
Blocked
Done
```

Recommended visible fields on the Project Board:

```text id="foobar123"
Labels
Assignees
Sprint
Estimate
```

This board shows both backlog and sprint execution states. The `Product backlog` column is not part of the sprint; it is included so the whole workflow is visible in one place.

---

## 9. Create Product Backlog Issues

All Product Backlog Items are GitHub issues.

A Product Backlog Issue may be:

```text id="f7t1tq"
A story
A bug report
A chore
Another requested product change
```

### Story example

```text id="7obxqg"
Title:
Story: Reset password

Labels:
story, ready

Body:
As a user, I want to reset my password so that I can regain access to my account.

Acceptance tests:

Scenario: User successfully resets their password
Given the user has requested a password reset
And the user has received a valid password reset link
When the user opens the password reset link
And enters a new valid password
And confirms the new password
And submits the password reset form
Then the system updates the user's password
And the user sees a confirmation message
And the user can log in using the new password
And the user can no longer log in using the old password
```

### Bug example

```text id="wpv2bo"
Title:
Bug: Password reset link is invalid

Labels:
bug, ready

Body:
Observed behavior:
The password reset email contains a link that opens an error page.

Expected behavior:
The link should open the password reset form.

Steps to reproduce:
1. Request a password reset.
2. Open the email.
3. Click the reset link.

Done when:
The reset link opens a valid password reset form.
```

### Chore example

```text id="wzhkya"
Title:
Chore: Add CI pipeline

Labels:
chore, ready

Body:
Goal:
Set up automatic checks for the project.

Done when:
- Tests run automatically on every pull request.
- The build fails if tests fail.
```

Set Project fields:

```text id="y4h3xi"
Status: Product backlog
PO Rank: 1, 2, 3...
Priority: High / Medium / Low
Estimate: optional
```

---

## 10. When is an item ready?

A Product Backlog Issue gets the `ready` label only when the team understands what “done” means.

Use this rule:

```text id="rybydo"
Story: has acceptance tests
Bug: has observed behavior, expected behavior, and reproduction steps
Chore: has a clear completion condition
```

If an issue is still vague, leave it in the backlog but do **not** add the `ready` label.

---

## 11. Sprint planning

At sprint planning:

1. Look at Product Backlog Issues with the `ready` label.
2. Use `PO Rank` to identify the highest-priority items.
3. Select the items for the sprint, up to the team’s sprint capacity or expected velocity.

During the second part of sprint planning, for each selected item, create one or more **sprint task issues**.

A sprint task issue should reference the selected Product Backlog Issue.

### Story task example

```text id="pl884s"
Title:
Make the acceptance tests for #12 pass

Labels:
task

Body:
Implement the behavior specified in Product Backlog Issue #12.

Done when:
- All acceptance tests in #12 pass.
- The implementation is reviewed.
- The related pull request is merged.
```

### Bug task example

```text id="b4w1h0"
Title:
Fix the password reset link bug described in #18

Labels:
task

Body:
Fix the bug described in Product Backlog Issue #18.

Done when:
- The bug can no longer be reproduced.
- The expected behavior in #18 is satisfied.
- The related pull request is merged.
```

Set the sprint task fields:

```text id="1ad3eu"
Status: Sprint backlog
Sprint: current sprint
Assignee: responsible student
```

---

## 12. During the sprint

Work on **sprint task issues**.

Move task issues through:

```text id="vxlw7r"
Sprint backlog → In progress → Done
```

Use:

```text id="vecyvp"
Blocked
```

only when work cannot continue.

Examples:

```text id="5ak3a7"
Waiting for teammate review
Unclear requirement
Technical problem preventing progress
```

---

## 13. Pull requests

For each sprint task:

1. Create a branch.
2. Implement the change.
3. Open a pull request.
4. Link the pull request to the sprint task issue.
5. Ask a teammate to review it.
6. Merge the pull request.
7. Move the task issue to `Done`.

Recommended rule:

```text id="19a5wg"
No important code goes directly to main.
Use pull requests.
```

---

## 14. Closing Product Backlog Issues

When all sprint task issues related to a Product Backlog Issue are done:

1. Check that the acceptance tests, bug-fix conditions, or chore completion criteria are satisfied.
2. Move the Product Backlog Issue to `Done`, or close it.
3. Keep the sprint task issues as evidence of the implementation work.

Traceability should look like this:

```text id="0ufjdi"
Product Backlog Issue → Sprint task issue → Pull request → Merged code
```

---

## 15. Suggested roles

For a group of 3–4 students:

```text id="dvp3et"
Product Owner:
Orders the backlog and decides when issues are ready.

Scrum Master:
Keeps the board clean and tracks blockers.

Developers:
Implement sprint task issues and review pull requests.
```

Roles can rotate every sprint.

---

## 16. Minimal workflow summary

```text id="kop4wi"
1. Create all backlog items as GitHub issues.
2. Label them as story, bug, chore, or task.
3. Add the ready label only when the item is clear enough for sprint planning.
4. Use the Project Table as the shared planning workspace.
5. Product Owner ranks ready backlog issues with PO Rank.
6. During sprint planning, create task issues for selected backlog items.
7. Move task issues through Sprint backlog, In progress, Blocked, Done.
8. Implement code through pull requests.
9. Close the Product Backlog Issue when its conditions are satisfied.
```