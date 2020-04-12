package com.diousk.scopeddagger.di

import com.diousk.scopeddagger.di.user.UserComponent
import dagger.Module

@Module(subcomponents = [UserComponent::class])
class AppSubcomponents