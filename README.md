Original App Design Project - README Template
===

# Youtube Liked Wrapped

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Present a user information about their past liked videos on Youtube, like the channel they liked the most, the genre they liked the most, and etc.

### App Evaluation
- **Category:** Youtube
- **Mobile:** Would be initially created for mobile, as similar to Spotify Wrapped, it is only visible through the mobile app. However a website would be nice because youtube is commonly used through desktop. But a mobile app is the main focus at this moment.
- **Story:** Summarizes the user’s Youtube activity in their last few liked videos, and analyzes what kinds of videos the user has frequently liked.
- **Market:** Any Youtube user who spends a considerable amount of time watching Youtube videos.
- **Habit:** The app is not intended to be used often. The app provides information about their activity over a long amount of time, so the user would not be expected to check it often.**
- **Scope:** The user is the main scope, as the information is self tailored to when you sign in. However in the future we could allow for users to share their Youtube Liked Wrapped with friends and family.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**
* Users can sign into Youtube using OAuth login
* Users will be able to see data about their last liked videos over the past 50 liked videos
* Users can see data such as their most liked channel, favorite genre, and most recently liked videos.

**Optional Nice-to-have Stories**

* Users can choose between their last liked 100, 150, 200, and 250 videos for their wrapped to take into account.
* Wrapped screen will be expanded across multiple screens.
*Users can choose get their wrapped from their last year of liked videos
*Users can choose to get their wrapped based on their dislike videos.
*Add additional screens to accommodate updated ideas.
*Users will able to see more statistics regarding their past liked videos
* Improved UI implementation
*Users can share their wrapped with friends or on social media


### 2. Screen Archetypes

* Login screen
   * Will have a sign in button to redirect you to the Youtube login
   * After login, will be sent to the Wrapped screen
* Wrapped View Pager
   * Shows your favorite channels, most watched videos, and favorite genre all in two swipable fragments

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Login screen
* Wrapped View Pager (2 Pages)

**Flow Navigation** (Screen to Screen)

* Login screen -> OAuth Youtube Login
* OAuth Youtube Login -> Wrapped View Pager
* Wrapped View Pager -> (Optional) login a new User

## Wireframes
<img src="https://github.com/UCI-Android-Group-4/youtube-wrapped/blob/main/wireframe1.PNG" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src="https://github.com/UCI-Android-Group-4/youtube-wrapped/blob/main/figma_mockup.jpg" width=600>

### [BONUS] Interactive Prototype

<img src="https://github.com/UCI-Android-Group-4/youtube-wrapped/blob/main/youtube_wrapped_figma.gif" width=250><br>
https://www.figma.com/proto/jBVZn2pu317AiImGbn0tK2/Untitled?node-id=5%3A2&scaling=scale-down


## Schema 
### Models
#### No models required for this Application
### Networking
#### List of network requests by screen
   - Login Screen
      - (Read/GET) Get token from user's Youtube acount for OAuth Login
   - Wrapped View Pager
      - (Read/GET) Get user's liked videos
      - (Read/GET) Get video data from those liked videos
      
